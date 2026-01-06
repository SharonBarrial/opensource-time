package com.sportnet.platform.u202212721.booking.interfaces.rest.resources;

/**
 * SportEventResource
 * <p>
 *     This class is a record class that represents the SportEventResource object.
 * </p>
 * @param id
 * @param eventName
 * @param organizerId
 * @param sportType
 * @param location
 * @param capacity
 * @author  U202212721 Mathias Jave Diaz
 * @version  1.0
 */
public record SportEventResource(Long id,String eventName, Long organizerId, String sportType, String location, Integer capacity) {
}
