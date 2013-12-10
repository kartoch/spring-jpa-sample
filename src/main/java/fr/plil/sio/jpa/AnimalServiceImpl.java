package fr.plil.sio.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Resource
    private AnimalRepository animalRepository;

    @Resource
    private OwnerRepository ownerRepository;


    @Override
    @Transactional
    public Animal createAnimal(String nameAnimal, String nameOwner) {
        if (nameAnimal == null || nameOwner == null) {
            throw new NullPointerException("animal or owner name must be not null");
        }

        Owner owner = ownerRepository.findByName(nameOwner);

        if (owner == null) {
            throw new IllegalArgumentException("cannot found owner");
        }

        Animal animal = new Animal();
        animal.setName(nameAnimal);
        owner.addAnimal(animal);
        animalRepository.save(animal);

        return animal;
    }

    @Override
    @Transactional
    public void removeAnimal(String name) {
        Animal animal = animalRepository.findByName(name);

        if (animal == null) {
            throw new IllegalArgumentException("animal not present");
        }

        animalRepository.delete(animal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Animal findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must be not null");
        }

        return animalRepository.findByName(name);
    }
}