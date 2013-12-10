package fr.plil.sio.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

    @Resource
    private OwnerRepository ownerRepository;

    @Override
    @Transactional
    public Owner createOwner(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must be not null");
        }

        if (ownerRepository.findByName(name) != null) {
            throw new IllegalArgumentException("owner already present");
        }

        Owner owner = new Owner();
        owner.setName(name);
        ownerRepository.save(owner);

        return owner;
    }

    @Override
    @Transactional
    public void removeOwner(String name) {
        Owner owner = ownerRepository.findByName(name);

        if (owner == null) {
            throw new IllegalArgumentException("owner not present");
        }

        ownerRepository.delete(owner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must be not null");
        }

        return ownerRepository.findByName(name);
    }
}
