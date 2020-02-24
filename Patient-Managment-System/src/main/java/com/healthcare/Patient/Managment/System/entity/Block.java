package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

@Entity
@Table(name="block")
public class Block {
	
	@EmbeddedId
	private BlockId blockId;

	public Block() {
		super();
	}

	public BlockId getBlockId() {
		return blockId;
	}

	public void setBlockId(BlockId blockId) {
		this.blockId = blockId;
	}
}
