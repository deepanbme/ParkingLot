package repository;

import exceptions.TicketIdNotFoundException;
import model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId){
        Ticket ticket =  ticketMap.get(ticketId);
        if(ticket == null){
            throw new TicketIdNotFoundException("Ticket not found for: " + ticketId);
        }
        return ticket;
    }

    public void put(Ticket ticket){
        ticketMap.put(ticket.getId(), ticket);
        System.out.println("Ticket has been added successfully");
    }
}
