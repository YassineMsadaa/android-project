package com.example.wamya.models;

import java.util.List;

public class Annonce {
    public enum AnnonceType {
        Plomberie,
        Electricité,
        Autre
    }
    private String title;
    private String description;
    private AnnonceType type;
    private boolean isServiceProvider;
    private User user; // Reference to the user who created the annonce
    private List<Reservation> reservations;
    private List<Evaluation> evaluations;

    // Constructors, getters, and setters
}