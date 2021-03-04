package com.medesta.service.impl;

import com.medesta.model.enums.Office;
import com.medesta.model.entity.Procedure;
import com.medesta.repository.ProcedureRepository;
import com.medesta.service.ProcedureService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    public ProcedureServiceImpl(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    @Override
    public void initAllProcedure() {
        if (procedureRepository.count() == 0) {

            Procedure laser = new Procedure();
            laser.setName("Laser");
            laser.setDescription("High quality technic for hair remove!");
            laser.setOffice(Office.LASER);
            laser.setMinutes(30);
            laser.setPrice(BigDecimal.valueOf(100));


            Procedure venus = new Procedure();
            venus.setName("Venus");
            venus.setDescription("High quality technic for wrinkles remove!");
            venus.setOffice(Office.VENUS_LPG);
            venus.setMinutes(60);
            venus.setPrice(BigDecimal.valueOf(150));

            Procedure piling = new Procedure();
            piling.setName("Piling");
            piling.setDescription("High quality technic for face cleaning!");
            piling.setOffice(Office.HYDRAFACIAL);
            piling.setMinutes(40);
            piling.setPrice(BigDecimal.valueOf(80));


            procedureRepository.saveAll(List.of(venus,laser,piling));
        }
    }
}
