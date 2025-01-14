package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;
import org.springframework.samples.petclinic.activemq.Publisher;
import org.springframework.samples.petclinic.db.OwnerRepository;
import org.springframework.samples.petclinic.db.PetRepository;
import org.springframework.samples.petclinic.db.VisitRepository;
import org.springframework.samples.petclinic.managementdto.RevenueRegistration;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

  private final OwnerRepository owners;
  private final PetRepository pets;
  private final VisitRepository visits;

  private final Publisher publisher;

  public ClinicService(
      OwnerRepository owners,
      PetRepository pets,
      VisitRepository visits,
      Publisher publisher) {
    this.owners = owners;
    this.pets = pets;
    this.visits = visits;
    this.publisher = publisher;
  }

  public Collection<Owner> ownerByLastName(String lastName) {
    return owners.findByLastName(lastName);
  }

  public Owner ownerById(int i) {
    return owners.findById(i);
  }

  public Pet petById(int id) {
    return pets.findById(id);
  }

  public List<PetType> petTypes() {
    return pets.findPetTypes();
  }

  public List<Visit> visitsByPetId(int petId) {
    return visits.findByPetId(petId);
  }

  public void save(Owner owner) {
    owners.save(owner);
  }

  public void save(Pet pet) {
    pets.save(pet);
  }

  public void save(Visit visit) {
    visits.save(visit);
    publisher.sendMessage(new RevenueRegistration(visit.getDate(), visit.getCost()));
  }

}
