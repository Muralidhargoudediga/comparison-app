package com.mediga.comparisonapp.controller;

import com.mediga.comparisonapp.exception.CarNotFoundException;
import com.mediga.comparisonapp.exception.ComparisonException;
import com.mediga.comparisonapp.model.ComparisonRequest;
import com.mediga.comparisonapp.model.ComparisonResponse;
import com.mediga.comparisonapp.service.ComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComparisonController {
    @Autowired
    private ComparisonService comparisonService;

    @PostMapping("/cars/comparison")
    public ResponseEntity<ComparisonResponse> compareCars(@RequestBody ComparisonRequest comparisonRequest) throws CarNotFoundException, ComparisonException {
        ComparisonResponse comparisonResponse = comparisonService.compareCars(comparisonRequest);
        ResponseEntity<ComparisonResponse> responseEntity = new ResponseEntity<>(comparisonResponse, HttpStatus.OK);
        return responseEntity;
    }
}
