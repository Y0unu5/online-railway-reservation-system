package com.cg.orrs.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.orrs.ticketservice.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
