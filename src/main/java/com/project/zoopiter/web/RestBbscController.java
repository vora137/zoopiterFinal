package com.project.zoopiter.web;

import com.project.zoopiter.domain.bbsc.svc.BbscSVC;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bbsc")
@RequiredArgsConstructor
public class RestBbscController {

  private final BbscSVC bbscSVC;

  @GetMapping("/{id}/like")
  public RestResponse<Object> increaseLikeCnt(@PathVariable("id") Long id){
    RestResponse<Object> res = null;

    int updatedCnt = bbscSVC.increaseLikeCount(id);

    if(updatedCnt == 1){
      res = RestResponse.createRestResponse("00","성공",updatedCnt);
      return res;
    }else{
      res = RestResponse.createRestResponse("99","실패",updatedCnt);
      return res;
    }
  }
  @DeleteMapping("/{id}/like")
  public RestResponse<Object> decreaseLikeCnt(@PathVariable("id") Long id){
    RestResponse<Object> res = null;

    int updatedCnt = bbscSVC.decreaseLikeCount(id);

    if(updatedCnt == 1){
      res = RestResponse.createRestResponse("00","성공",updatedCnt);
      return res;
    }else{
      res = RestResponse.createRestResponse("99","실패",updatedCnt);
      return res;
    }
  }

}
