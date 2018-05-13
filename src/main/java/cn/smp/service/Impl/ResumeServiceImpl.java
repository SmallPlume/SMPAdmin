package cn.smp.service.Impl;

import cn.smp.service.ResumeService;
import com.sun.scenario.effect.impl.prism.ps.PPStoPSWDisplacementMapPeer;
import com.sun.scenario.effect.impl.prism.sw.PSWDrawable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import sun.applet.Main;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

    public static final String Key = "10086";

    @Override
    public boolean storeResume() {
        // TODO Auto-generated method stub
        System.out.println("任务已经执行.....................................");
        return true;
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("id", "10086");


        String compactJws = Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512, "10086")
                .compact();
        System.out.println(compactJws);
    }
}
