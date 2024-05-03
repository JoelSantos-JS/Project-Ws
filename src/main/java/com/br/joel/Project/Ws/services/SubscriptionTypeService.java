package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.DTO.SubsCriptionTypeDto;
import com.br.joel.Project.Ws.exceptions.NotFoundException;
import com.br.joel.Project.Ws.model.SubscriptionType;
import com.br.joel.Project.Ws.repository.SubscriptionTypeRepository;
import com.br.joel.Project.Ws.services.util.CopyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeService {


    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionTypeService(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }



    public List<SubscriptionType> listAllSubscriptionTypes() {
        return  subscriptionTypeRepository.findAll();
    }

    public SubscriptionType findById(Long id) throws RuntimeException {

        return  subscriptionTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("Subs not found"));

    }


    public SubscriptionType save(SubsCriptionTypeDto type) {
        SubscriptionType subscriptionType = new SubscriptionType();

        copyEntitySubs(subscriptionType, type);
        return  subscriptionTypeRepository.save(subscriptionType);
    }



    public  SubscriptionType update(Long id , SubsCriptionTypeDto type) {
        SubscriptionType subscriptionType = findById(id);

        if(subscriptionType != null) {
                 copyEntitySubs(subscriptionType , type);
            return  subscriptionTypeRepository.save(subscriptionType);
        }


        return  null;

    }


    public void deleteSubs(Long id) {

        subscriptionTypeRepository.deleteById(id);
    }





    public void  copyEntitySubs(SubscriptionType subscriptionType, SubsCriptionTypeDto dto) {
        subscriptionType.setName(dto.getName());
        subscriptionType.setPrice(dto.getPrice());
        subscriptionType.setAccess_months(dto.getAccess_months());
        subscriptionType.setProductKey(dto.getProductKey());
    }
}
