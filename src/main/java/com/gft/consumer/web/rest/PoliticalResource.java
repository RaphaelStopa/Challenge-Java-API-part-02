package com.gft.consumer.web.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gft.consumer.service.Impl.PoliticalServiceImpl;
import com.gft.consumer.web.rest.vm.LoginVM;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PoliticalResource {

    private final PoliticalServiceImpl politicalService;

    public PoliticalResource(PoliticalServiceImpl politicalService) {
        this.politicalService = politicalService;
    }


//    @GetMapping(value = {"/politicians/{id}"})
//    public ResponseEntity<PoliticalVM> getPolitical(@PathVariable Long id){
//        PoliticalVM page = politicalService.requestAPI(id);
//        return ResponseEntity.ok().body(page);
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@RequestBody LoginVM loginVM) {
        String jwt = politicalService.getJWT(loginVM);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);

    }


    @GetMapping(value = {"/{electivePositionType}/asc"})
    public ResponseEntity<String> getAllPoliticiansAscendingAlphabeticalByName(@PathVariable(value = "electivePositionType") final String electivePositionType,
                                                                               @RequestHeader(value = "Authorization") String authorization,
                                                                               @RequestParam(name = "page", required = false) Long page,
                                                                               @RequestParam(name = "size", required = false) Long size){
        String result = politicalService.getAllPoliticiansAscendingAlphabeticalByname(electivePositionType, authorization, page, size);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = {"/{electivePositionType}/desc"})
    public ResponseEntity<String> getAllPoliticiansDescendingAlphabeticalByName(@PathVariable(value = "electivePositionType") final String electivePositionType,
                                                                                @RequestHeader(value = "Authorization") String authorization,
                                                                                @RequestParam(name = "page", required = false) Long page,
                                                                                @RequestParam(name = "size", required = false) Long size)
    {
        String result = politicalService.getAllPoliticiansDescendingAlphabeticalByname(electivePositionType, authorization, page, size);
        return ResponseEntity.ok().body(result);
    }
    

    @GetMapping(value = {"/{electivePositionType}/laws/{amount}"})
    public ResponseEntity<String> getAllPoliticiansByTheNumberOfLaws(@PathVariable(value = "electivePositionType") final String electivePositionType,
                                                                                @PathVariable(value = "amount") final String amount,
                                                                     @RequestHeader(value = "Authorization") String authorization,
                                                                     @RequestParam(name = "page", required = false) Long page,
                                                                     @RequestParam(name = "size", required = false) Long size){
        String result = politicalService.getAllPoliticiansByTheNumberOfLaws(electivePositionType, amount, authorization, page, size);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = {"/{electivePositionType}/{id}"})
    public ResponseEntity<String> getAllPoliticiansById(@PathVariable(value = "electivePositionType") final String electivePositionType,
                                                                     @PathVariable(value = "id") final String id,
                                                        @RequestHeader(value = "Authorization") String authorization,
                                                        @RequestParam(name = "page", required = false) Long page,
                                                        @RequestParam(name = "size", required = false) Long size){
        String result = politicalService.getAllPoliticiansById(electivePositionType, id, authorization, page, size);
        return ResponseEntity.ok().body(result);
    }

    static class JWTToken {
        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }

}
