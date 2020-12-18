package sk.stuba.fei.uim.asos.assignment2.insurance.web;

import sk.stuba.fei.uim.asos.assignment2.insurance.service.InsuranceContractService;
import sk.stuba.fei.uim.asos.assignment2.ws.*;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
import java.util.stream.Collectors;

@WebService(name = "InsuranceServicePortType", targetNamespace = "insurances-service", serviceName = "InsuranceService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ObjectFactory.class})
public class InsuranceServicePort implements InsuranceServicePortType {

    private final InsuranceContractService insuranceService;

    public InsuranceServicePort() {
        this.insuranceService = new InsuranceContractService();
    }

    public InsuranceServicePort(InsuranceContractService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @Override
    @WebMethod
    @WebResult(name = "insurance", targetNamespace = "insurances", partName = "body")
    public InsuranceType add(InsuranceType parameter) {
        return toInsuranceType(insuranceService.create(toInsurance(parameter)));
    }

    @Override
    @WebMethod
    @WebResult(name = "insurance", targetNamespace = "insurances", partName = "body")
    public InsuranceType update(InsuranceType parameter) {
        return toInsuranceType(insuranceService.update(toInsurance(parameter)));
    }

    @Override
    @WebMethod
    @WebResult(name = "insurances", targetNamespace = "insurances", partName = "body")
    public Insurances all() {
        return toInsurances(insuranceService.getAll());
    }

    @Override
    @WebMethod
    @WebResult(name = "insurances", targetNamespace = "insurances", partName = "body")
    public Insurances byUser(long parameter) {
        return toInsurances(insuranceService.getByUserId(parameter));
    }

    private AbstractInsurance toInsurance(InsuranceType type) {
        if (type.getTravelInsurance() != null)
            return type.getTravelInsurance();
        if (type.getInjuryInsurance() != null)
            return type.getInjuryInsurance();
        if (type.getHouseholdInsurance() != null)
            return type.getHouseholdInsurance();
        if (type.getHouseInsurance() != null)
            return type.getHouseInsurance();
        throw new UnsupportedOperationException("Application cannot resolve request insurance type");
    }

    private InsuranceType toInsuranceType(AbstractInsurance insurance) {
        InsuranceType insuranceType = new InsuranceType();
        if (insurance instanceof TravelInsurance) {
            insuranceType.setTravelInsurance((TravelInsurance) insurance);
        }
        if (insurance instanceof InjuryInsurance) {
            insuranceType.setInjuryInsurance((InjuryInsurance) insurance);
        }
        if (insurance instanceof HouseholdInsurance) {
            insuranceType.setHouseholdInsurance((HouseholdInsurance) insurance);
        }
        if (insurance instanceof HouseInsurance) {
            insuranceType.setHouseInsurance((HouseInsurance) insurance);
        }
        return insuranceType;
    }

    private Insurances toInsurances(List<AbstractInsurance> insurances) {
        Insurances ins = new Insurances();
        ins.getInsurance().addAll(insurances.stream().map(this::toInsuranceType).collect(Collectors.toList()));
        return ins;
    }
}
