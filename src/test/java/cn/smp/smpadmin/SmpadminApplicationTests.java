package cn.smp.smpadmin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmpadminApplicationTests {

	private static final String key = "alibaba10086";

	//该方法使用HS256算法和Secret:bankgl生成signKey
	private static Key getKeyInstance() {
		//We will sign our JavaWebToken with our ApiKey secret
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return signingKey;
	}

	//使用HS256签名算法和生成的signingKey最终的Token,claims中是有效载荷
	public static String createJavaWebToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
	}

	//解析Token，同时也能验证Token，当验证失败返回null
	public static Map<String, Object> parserJavaWebToken(String jwt) {
		try {
			Map<String, Object> jwtClaims =
					Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
			return jwtClaims;
		} catch (Exception e) {
			return null;
		}
	}

	@Test
	public void contextLoads() {
		Map map = new HashMap();
		map.put("name", "张三");
		map.put("id", "10086");

		String token = createJavaWebToken(map);
		System.out.println("token ===== " + token);

		Map resultMap = parserJavaWebToken(token);
		System.out.println(resultMap);
	}



}
