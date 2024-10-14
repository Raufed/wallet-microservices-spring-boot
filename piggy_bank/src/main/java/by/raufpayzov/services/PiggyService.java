package by.raufpayzov.services;

import by.raufpayzov.entity.Piggy;
import by.raufpayzov.repository.PiggyRepository;
import lombok.Data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@Service
public class PiggyService {
    @Autowired
    private PiggyRepository piggyRepository;

    public PiggyService(PiggyRepository piggyRepository) {
        this.piggyRepository = piggyRepository;
    }

    public List<Piggy> getAllPiggies() {
        return piggyRepository.findAll();
    }

    public Optional<Piggy> getPiggyById(Long id) {
        return piggyRepository.findById(id);
    }

    public Piggy createPiggy(Piggy piggy) {
        return piggyRepository.save(piggy);
    }

    public Piggy updatePiggy(Long id, Piggy piggy) {
        if (piggyRepository.existsById(id)) {
            piggy.setId(id);
            return piggyRepository.save(piggy);
        } else {
            return null; // Handle not found case
        }
    }

    public Piggy topUpBalance(Long id, double balance) {
        if (piggyRepository.existsById(id)) {
            Piggy piggy = piggyRepository.findById(id).orElseThrow();
            double totalBalance = piggy.getBalance() + balance;
            piggy.setBalance(totalBalance);
            piggyRepository.save(piggy);
            return piggy;
        } else {
            return null; // Handle not found case
        }
    }

    public void deletePiggy(Long id) {
        piggyRepository.deleteById(id);
    }
}