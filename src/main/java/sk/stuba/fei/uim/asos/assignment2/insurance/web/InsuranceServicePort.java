package sk.stuba.fei.uim.asos.assignment2.insurance.web;

import sk.stuba.fei.uim.asos.assignment2.insurance.service.InsuranceContractService;
import sk.stuba.fei.uim.asos.assignment2.ws.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import java.util.List;
import java.util.stream.Collectors;

@WebService(name = "InsuranceServicePortType", targetNamespace = "insurances", serviceName = "InsuranceService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ObjectFactory.class})
public class InsuranceServicePort {

//    private final InsuranceContractService insuranceService;
//
//    public InsuranceServicePort(InsuranceContractService insuranceService) {
//        this.insuranceService = insuranceService;
//    }
//
//    @Override
//    public Insurances getAll(long id) {
//        Insurances insurances = new Insurances();
//        List<InsuranceBase> insuranceList = insuranceService.getByUserId(id);
//        if (insuranceList.isEmpty())
//            return insurances;
//
//
//        return insurances;
//    }
//
//    @Override
//    public void add(Holder<InsuranceType> insurance) {
//        if (insurance.value.getInjuryInsurance() != null)
//            insuranceService.create(insurance.value.getInjuryInsurance());
//        if (insurance.value.getTravelInsurance() != null)
//            insuranceService.create(insurance.value.getTravelInsurance());
//        if (insurance.value.getHouseholdInsurance() != null)
//            insuranceService.create(insurance.value.getHouseholdInsurance());
//        if (insurance.value.getHouseInsurance() != null)
//            insuranceService.create(insurance.value.getHouseInsurance());
//    }
}
