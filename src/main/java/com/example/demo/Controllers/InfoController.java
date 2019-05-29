package com.example.demo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {
    @RequestMapping("/calc")
    public ResponseEntity calcXplusY(@RequestBody Map<String, Integer> map){
        int x = map.get("x");
        int y = map.get("y");
        int result = x + y;

        Result result1 = new Result();
        result1.setResult(result);

//        return ResponseEntity.ok( "{\"result\":" +  result + "}");
        return ResponseEntity.ok( result1 );
    }


    class Result{
        int result = 0;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}
