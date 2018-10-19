/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/19
  Time: 13:38
  To change this template use File | Settings | File Templates.
*/
package org.mml.demo.controller;

import com.baidu.ai.api.auth.AuthService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.json.JSONObject;
import org.mml.demo.model.KnowledgeData;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController()
@RequestMapping(value="/knowledge")
public class KnowledgeController {
    private String urlHost="https://aip.baidubce.com/rpc/2.0/kg/v1/cognitive/entity_annotation";
    @ApiOperation(value="获取知识图谱", notes="")
    @ApiImplicitParam(name = "knowledgeData", value = "json格式数据,data内容为关键字", required = true, dataType = "KnowledgeData")
    @PostMapping("/infor")
    public String postInfor(@RequestBody KnowledgeData knowledgeData){
        String access_token=AuthService.getAuth();
        String result="";
        String fullURL=null;
        if(access_token!=null){
            fullURL=urlHost+"?access_token="+access_token;
        }
        if(fullURL!=null){
            try {
                URL realUrl = new URL(fullURL);
                // 打开和URL之间的连接
                HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
                // 设置是否向connection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true
                connection.setDoOutput(true);
                // Read from the connection. Default is true.
                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                //设置长连接
                connection.setRequestProperty("Connection","keep-Alive");
                //设置字符集
                connection.setRequestProperty("Charset","utf-8");
                //转换为字节数组
                byte[] data = (knowledgeData.toString()).getBytes();
                // 设置文件长度
                connection.setRequestProperty("Content-Length", String.valueOf(data.length));
                // 设置文件类型:
                connection.setRequestProperty("contentType", "application/json");
                connection.connect();
                OutputStream out = connection.getOutputStream();
                // 写入请求的字符串
                out.write(data);
                out.flush();
                out.close();
                // 定义 BufferedReader输入流来读取URL的响应
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                System.out.println("result:" + result);
            }catch (Exception e) {
                System.err.printf("获取失败！");
                e.printStackTrace(System.err);
            }
        }
        return result;
    }
}
