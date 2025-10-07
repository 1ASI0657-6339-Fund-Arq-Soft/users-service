package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

public record CreateScheduleResource(
        String day,
        String startTime,
        String endTime,
        Long appointmentId
) {}
