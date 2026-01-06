package com.sportnet.platform.u202212721.booking.domain.model.commands;

/**
 * CreateSportEventCommand
 * <p>
 *     This class represents the CreateSportEventCommand. It contains the attributes of a sport event.
 * </p>
 * @param eventName
 * @param organizerId
 * @param sportType
 * @param location
 * @param capacity
 * @author  U202212721 Mathias Alejandro Jave Diaz
 * @version 1.0
 */
public record CreateSportEventCommand(String eventName, Long organizerId, String sportType, String location, Integer capacity) {
}
