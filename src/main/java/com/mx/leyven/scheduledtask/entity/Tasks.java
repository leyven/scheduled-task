/*
 * Financiera Independencia.
 * Copyright (C)  All rights reserved. Todos los derechos reservados 2019.   
 * mailto:
 *
 * License as published by Financiera Independencia. 
 * Licencia publicada por Financiera Independencia version 1 .
 *
 * Catalogo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.mx.leyven.scheduledtask.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Simple table
 * 
 * @author ECGOMEZ
 */
@Data
@Entity
@Table(name = "tasks")
public class Tasks implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "scheduled_time")
	private String scheduledTime;

	@Column(name = "payload")
	private String payload;

	@Column(name = "endpoint")
	private String endpoint;

	@Column(name = "active")
	private Boolean active;


}
