package com.adithya.MAMS.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "from_base_id")
    private Base fromBase;

    @ManyToOne
    @JoinColumn(name = "to_base_id")
    private Base toBase;

    @ManyToOne
    @JoinColumn(name = "transferred_by")
    private User transferredBy;

    private LocalDate transferDate;
}

