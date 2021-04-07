package br.com.revendedora.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ Default.class, CreateContactValidationInterface.class})

public interface ValidationSequenceCreate {
}
