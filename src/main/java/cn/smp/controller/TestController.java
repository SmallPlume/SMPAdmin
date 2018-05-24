package cn.smp.controller;

import cn.smp.facade.service.UserFacade;
import com.alibaba.fastjson.JSON;
import lombok.Data;
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
public class TestController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getCommunity")
    public String getCommunity() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/tenantstructures";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\n" +
                "    \"pattern\":3,\n" +
                "    \"structure\":{\n" +
                "        \"areaID\":\"440404100003\",\n" +
                "        \"buildingNum\":2,\n" +
                "        \"buildingNumStart\":1,\n" +
                "        \"floorNum\":3,\n" +
                "        \"floorNumStart\":1,\n" +
                "        \"periodNum\":0,\n" +
                "        \"regionNum\":0,\n" +
                "        \"roomNum\":3,\n" +
                "        \"roomNumStart\":1,\n" +
                "        \"unitNum\":2,\n" +
                "        \"unitNumStart\":1,\n" +
                "        \"villageName\":\"API测试的社区\"\n" +
                "    },\n" +
                "    \"tenantCode\":\"T0001\"\n" +
                "}";

        /*Community community = new Community();
        community.setPattern(3);
        community.setTenantCode("T0001");
        Structure structure = new Structure();
        structure.setAreaID("440404100003");
        structure.setBuildingNum(2);
        structure.setBuildingNumStart(1);
        structure.setFloorNum(3);
        structure.setFloorNumStart(1);
        structure.setPeriodNum(0);
        structure.setRegionNum(0);
        structure.setRoomNum(3);
        structure.setRoomNumStart(1);
        structure.setUnitNum(2);
        structure.setUnitNumStart(1);
        structure.setVillageName("api测试社区123456");
        community.setStructure(structure);*/
        // String requestJson = JSON.toJSONString(requestJson);

        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String result = restTemplate.postForObject(url, entity, String.class);
        System.out.println(new String(result.getBytes("ISO-8859-1"), "UTF-8"));
        return new String(result.getBytes("ISO-8859-1"), "UTF-8");
    }

    @GetMapping("/getDoor")
    public String getDoor() throws UnsupportedEncodingException {
        String url = "http://t3-spl.bit-inc.cn:21664/api/tenantunitdoors";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.set("Accept", MediaType.APPLICATION_JSON.toString());
        headers.set("Authorization", "Bearer gAAAANeiuSCtITAAvmPmpjXwbdWc7rB3xJJaqtz9wXHaNFCYuB_lnkQ1iy0oDrttqfJmWMiRP2mXoj4VUryu48Lmn8pIqltcmz6YqcmJFbVzSiFOCQZE9Rc3rUbn58gyWOVkIsLpGhaG1rlkM1wEGQKP78OpxcREgJQq3B-aB6fqHaP3RAEAAIAAAAARHLq4Q_z-fjYPizu27QfklmogD4TOQLoZpzO8TEGyFz4sQ2qiXemUSpUa6JaoA42VNt-t7zwQDHYAM0IuE6Y3aOFLwSW4U0sXXjuWFXF-nPCaEh6RqLagNB_D9n7TZ-mlTrbUiZgTJV7rhBrL_KeMbF_C-gkVz3OgKh2wjV3ISYjbt7cbJj9oIqyby6i0yh7-n6Uf8H-eIJ8TOYXCVtd-UIkDPYIW9GO_oiJ7xmFgS1J4hDCuvZm0ie3ikNT2O8MzP3YxLq3-3dbQ_p0QIJbw5ICaOxkYNJMDmtPKe5QJPffVJ9nnB_FwS9w3eRv2xkDnAzNykqGuNHsZRXVj6MfPR5gSjRKzAAixthI0_YDg18mwLnvo1a5oFBWuh3TtRaydXRUb8geUoCMIIw7rMVJjhL4paC9PS-EBk4jx2W0yGQ");
        String requestJson = "{\n" +
                "    \"ParentDirectory\":\"44\",\n" +
                "    \"TenantCode\":\"T0001\",\n" +
                "    \"BuildingNum\":2,\n" +
                "    \"BuildingNumStart\":1,\n" +
                "    \"BuildingDisplay\":\"栋\",\n" +
                "    \"UnitDisplay\":\"单元\"\n" +
                "}";

        System.out.println("rest ============= " + requestJson);
        HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        System.out.println(new String(result.getBody().getBytes("ISO-8859-1"), "UTF-8"));
        return new String(result.getBody().getBytes("ISO-8859-1"), "UTF-8");
    }


   /*@GetMapping("/test")
    public String Test() {
        userFacade.getUserById(1);
        return "test11";
    }*/
}

@Data
class Community implements Serializable{

    private String tenantCode;

    private Integer pattern;

    private Structure structure;

}

@Data
class Structure implements Serializable{
    private String areaID;

    private Integer buildingNum;

    private Integer buildingNumStart;

    private Integer floorNum;

    private Integer floorNumStart;

    private Integer periodNum;

    private Integer regionNum;

    private Integer roomNum;

    private Integer roomNumStart;

    private Integer unitNum;

    private Integer unitNumStart;

    private String villageName;

}
