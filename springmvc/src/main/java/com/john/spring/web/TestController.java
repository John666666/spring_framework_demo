package com.john.spring.web;

import com.john.spring.bean.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;

@Controller
public class TestController {

    /**
     * 简单请求参数获取
     * @param age
     * @param name
     * @param nickName
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String testSimple(@RequestParam("age") int age, @RequestParam(name = "name", required = false) String name, @RequestParam(value = "nickname", required = false) String nickName, Model model) {
        System.out.println("login, age: " + age+", name: " + name+", nickName: " + nickName);
        model.addAttribute("msg", age);
        return "main";
    }

    @RequestMapping("/test/bind_obj")
    public String testBindObject(Student student, Model model) {
        System.out.println("testBindObject, student: " + student);
        model.addAttribute("msg", student);
        return "main";
    }

    /**
     * 测试URI通配符
     * @return
     */
//    @RequestMapping("/test/pattern/*")    //可以匹配： /test/pattern/ /test/pattern/aa /test/pattern/bb ...  不能匹配：/test/pattern /test/pattern/aa/bb
//    @RequestMapping("/test/pattern/?")  //可以匹配：/test/pattern/a /test/pattern/b ... 不能匹配：/test/pattern/ /test/pattern/aa ...
    @RequestMapping("/test/pattern/**")  //可以匹配：/test/pattern /test/pattern/ /test/pattern/aa /test/pattern/aa/bb ...
    public String testPattern() {
        System.out.println("testPattern");
        return "main";
    }

    /**
     * 测试URI正则表达式支持
     * @param path
     * @param name
     * @param version
     * @param ext
     * @return
     */
    @GetMapping("/test/reg_pattern/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}") //匹配 /test/reg_pattern/spring-web-3.0.5.jar
//    @RequestMapping("/test/reg_pattern/{path:.*}")    //匹配 /test/reg_pattern/任意长度字符
    public String testRegPattern(@PathVariable(name = "path", required = false) String path,
                                 @PathVariable(name="name", required = false) String name,
                                 @PathVariable(name="version", required = false) String version,
                                 @PathVariable(name="ext", required = false) String ext) {
        System.out.println("testRegPattern, path: " + path);
        System.out.println("testRegPattern, name: " + name+", version: " + version+", ext: " + ext);
        return "main";
    }

    /**
     * 测试读取RequestBody
     * @param bodyContent
     * @param name
     * @return
     */
    @RequestMapping("/test/body")
    public String testRequestBody(@RequestBody(required = false) String bodyContent, @RequestParam(name = "name", required = false) String name) {
        System.out.println("testRequestBody, bodyContent: " + bodyContent +", name: " + name);
        return "main";
    }

    /**
     *  测试无返回值，直接返回httpstatus、或通过resp直接响应结果
     * @param out
     * @throws IOException
     */
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @RequestMapping("/test/httpcode")
    public void testRetHttpCode(OutputStream out) throws IOException{
        System.out.println("testRetHttpCode");
        out.write("你好，SpringMVC".getBytes("UTF-8"));
        out.close();
    }

    /**
     * 测试返回ResponseEntity
     * @return
     */
    @RequestMapping("/test/resp_entity")
    public ResponseEntity<String> testRespEntity() {
        System.out.println("testRespEntity");
        return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body("{\"name\": \"张三\", \"age\": 21}");
    }

    /**
     * 测试通过@ResopnseBody将返回内容直接写入响应体，适和RESTFull服务方式
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/test/resp_body", produces = "application/json;charset=UTF-8")
    public String testResponseBody() {
        System.out.println("testResponseBody");
        return "{\"name\": \"张三\", \"age\": 21}";
    }


}
