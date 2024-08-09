package com.example.insurance_app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/insurance")
public class Controller {


    @Autowired
    S3Service service;

    @Autowired
    S3UploadService s3UploadService;

    @Autowired
    PersonInsuranceRepository personInsuranceRepository;



    @PostMapping(value = "/postdata")
    public String postToRDS(PersonInsuranceDetails personInsuranceDetails)
    {

        personInsuranceRepository.save(personInsuranceDetails);

        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("memberid",personInsuranceDetails.getMemberid());
        sampleMap.put("planid",personInsuranceDetails.getPlanid());

        String pdfupload = generateAndUploadPdf(service,s3UploadService,sampleMap);
        System.out.println("pdfupload" + pdfupload);


     return "sent event & stored to RDS";

    }

    public String generateAndUploadPdf(S3Service service, S3UploadService s3UploadService , Map<String, String> data) {
        try {
            byte[] pdfData = service.generatePdf(data);
            String fileName = "form_" + System.currentTimeMillis() + ".pdf";
            s3UploadService.uploadPdf(pdfData, fileName);
            return "PDF generated and uploaded successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating or uploading PDF.";
        }
    }




}
