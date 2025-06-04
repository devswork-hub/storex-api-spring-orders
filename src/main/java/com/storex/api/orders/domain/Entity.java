package com.storex.api.orders.domain;

import java.time.Instant;
import java.util.Objects;

public abstract class Entity<ID extends Identifier> {
  protected ID id;
  protected Boolean isActive;
  protected Boolean isDisabled;
  protected final Instant createdAt;
  protected Instant updatedAt;
  protected Instant deletedAt;

  protected Entity(final ID id) {
    this.id = Objects.requireNonNull(id, "ID cannot be null");
    this.isActive = true;
    this.isDisabled = false;
    this.createdAt = Instant.now();
  }

  public ID getId() {
    return id;
  }

  public boolean isActive() {
    return isActive && !isDisabled;
  }

  public boolean isDisabled() {
    return isDisabled;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }

  public void disable() {
    this.isDisabled = true;
    touch();
  }

  public void enable() {
    this.isDisabled = false;
    touch();
  }

  public void markAsDeleted() {
    this.deletedAt = Instant.now();
    touch();
  }

  protected void touch() {
    this.updatedAt = Instant.now();
  }
}
