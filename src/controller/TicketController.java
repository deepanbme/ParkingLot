package controller;

import dto.IssueTicketRequestDto;
import dto.IssueTicketResponseDto;
import dto.ResponseStatus;
import exceptions.InvalidRequestException;
import model.Ticket;
import service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto getTicket(IssueTicketRequestDto issueTicketRequestDto){
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        Ticket ticket;

        try {
            if(issueTicketRequestDto.getGateId() == 0 ||
            issueTicketRequestDto.getVehicleNumber() == null ||
            issueTicketRequestDto.getVehicleType() == null){
                throw new InvalidRequestException("Ticket generation request data is invalid");
            }
            ticket = ticketService.getTicket(issueTicketRequestDto);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            issueTicketResponseDto.setTicket(ticket);

        }catch (Exception e){
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            issueTicketResponseDto.setFailureReason(e.getMessage());
        }

        return issueTicketResponseDto;
    }
}
