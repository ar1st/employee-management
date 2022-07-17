package com.aris.employee.management.api.controller;

import com.aris.employee.management.api.dto.attribute.GetAttributeDTO;
import com.aris.employee.management.api.dto.attribute.CreateAttributeDTO;
import com.aris.employee.management.api.dto.EmptyResponseDTO;
import com.aris.employee.management.api.dto.attribute.EditAttributeDTO;
import com.aris.employee.management.api.rest.ApiResponse;
import com.aris.employee.management.api.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("attributes")
@RequiredArgsConstructor
public class AttributesController {

    private final AttributeService attributeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetAttributeDTO>>> getAttributes() {
        List<GetAttributeDTO> attributes = attributeService.getAttributes();

        return ResponseEntity.ok(new ApiResponse<>(attributes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetAttributeDTO>> getAttribute(@PathVariable Integer id) {
        GetAttributeDTO attribute = attributeService.getAttribute(id);

        return ResponseEntity.ok(new ApiResponse<>(attribute));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmptyResponseDTO>> createAttribute(@RequestBody @Valid CreateAttributeDTO request) {
        attributeService.createAttribute(request.getName(), request.getValue());

        return ResponseEntity.ok(new ApiResponse<>());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmptyResponseDTO>> editAttribute(@PathVariable Integer id,
                                                                       @RequestBody @Valid EditAttributeDTO request) {
        attributeService.editAttribute(id, request.getValue());

        return ResponseEntity.ok(new ApiResponse<>());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<EmptyResponseDTO>> deleteAttribute(@PathVariable Integer id) {
        attributeService.deleteAttribute(id);

        return ResponseEntity.ok(new ApiResponse<>());
    }
}
