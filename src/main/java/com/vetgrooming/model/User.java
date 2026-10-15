package com.vetgrooming.model;

/**
 * Data model for a row in the users table.
 * A record is immutable and automatically gets a constructor,
 * getters (id(), username(), ...), equals(), hashCode() and toString().
 */
public record User(int id, String username, String password, String roles, String status) {
}
