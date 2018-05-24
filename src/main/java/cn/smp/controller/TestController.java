package cn.smp.controller;

import cn.smp.facade.service.UserFacade;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.awt.geom.AreaOp;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/smp")
@Slf4j
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 新增社区
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/addCommunity")
    public String getCommunity() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/tenantvillages";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\n" +
                "    \"TenantCode\":\"T0001\",\n" +
                "    \"AreaID\":440402000000,\n" +
                "    \"VillageName\":\"天蝎座\"\n" +
                "}";
        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String result = restTemplate.postForObject(url, entity, String.class);
        System.out.println(new String(result.getBytes("ISO-8859-1"), "UTF-8"));
        return new String(result.getBytes("ISO-8859-1"), "UTF-8");
    }

    /**
     * 新增位长
     * @return
     */
    @GetMapping("/addDefinition")
    public String addDefinition() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/TenantStructureDefinition";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\n" +
                "    \"TenantCode\":\"T0001\",\n" +
                "    \"StructureID\":47,\n" +
                "    \"Building\":3,\n" +
                "    \"Unit\":1,\n" +
                "    \"Floor\":3,\n" +
                "    \"Room\":3\n" +
                "}";
        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String result = restTemplate.postForObject(url, entity, String.class);
        System.out.println(new String(result.getBytes("ISO-8859-1"), "UTF-8"));
        return new String(result.getBytes("ISO-8859-1"), "UTF-8");
    }

    /**
     * 新增楼栋
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/addBuilding")
    public String addBuilding() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/tenantunitdoors";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.set("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\n" +
                "    \"TenantCode\":\"T0001\",\n" +
                "    \"ParentDirectory\":\"47-11-1\",\n" +
                "    \"BuildingNum\":1,\n" +
                "    \"UnitNum\":1,\n" +
                "    \"BuildingNumStart\":1,\n" +
                "    \"UnitNumStart\":1,\n" +
                "    \"BuildingDisplay\":\"栋\",\n" +
                "    \"UnitDisplay\":\"单元\"\n" +
                "}";
        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        String result_ = new String(result.getBody().getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("rest ======================== " + result_);
        return result_;
    }

    @GetMapping("/addTier")
    public String addTier() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/tenantstructures";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.set("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\"TenantCode\":\"T0001\",\"ParentDirectory\":\"45-1\",\"NodeNum\":2,\"NodeDisplay\":\"层\",\"NodeNumStart\":1}";
        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        String result_ = new String(result.getBody().getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("rest ======================== " + result_);
        return result_;
    }

    @GetMapping("/addRoom")
    public String addRoom() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/tenantstructures";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.set("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\"TenantCode\":\"T0001\",\"ParentDirectory\":\"45-1-1\",\"NodeNum\":2,\"Attribute\":10,\"NodeDisplay\":\"房\",\"NodeNumStart\":1}";
        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        String result_ = new String(result.getBody().getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("rest ======================== " + result_);
        return result_;
    }
}