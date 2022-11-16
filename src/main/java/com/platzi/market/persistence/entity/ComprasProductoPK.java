/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.market.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author davila
 */
@Embeddable
public class ComprasProductoPK implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3761310718614618270L;

	@Column(name = "id_compra")
    private Long idCompra;
    
    @Column(name = "id_producto")
    private Long idProducto;

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
    
}
