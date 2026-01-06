package com.sportnet.platform.u202212721.booking.interfaces.rest.resources;

/**
 * CreateSportEventResource
 * <p>
 *     This class is a record class that represents the resource for creating a sport event.
 * </p>
 * @param eventName
 * @param organizerId
 * @param sportType
 * @param location
 * @param capacity
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public record CreateSportEventResource(String eventName, Long organizerId, String sportType, String location, Integer capacity) {
}
