package com.dnb.accountservice.dto;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity

public class Account {


	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "account_seq")
	// @GenericGenerator(name = "account_seq", strategy =
	// "com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator", parameters = {
//			 @Parameter(name=CustomAccountIdGenerator.INCREMENT_PARAM,value ="50")})
//			 @Parameter(name =CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER,value="A_"),
	// @Parameter(name = CustomAccountIdGenerator.NUMBER_FORMAT_PARAMETER, value =
	// "_%05d") })

	@NotBlank(message = "account id should not be blank")
	public String accountId;
	@Column(nullable = false)
	@NotBlank(message = "account id should not be blank")
	private String accountHolderName;
	private String accountType;
	@Min(value = 0, message = "value should not be negative")
	private float balance;
	@Length(min = 10, max = 10)
	@NotBlank
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String contactNumber;
	private String address;
	private LocalDate accountCreatedDate = LocalDate.now();
	@NotNull(message = "Date should be added")
	// @NotBlank(message ="Date should not be blank")
	// @jakarta.validation.constraints.Pattern(regexp =
	// "^(\\d{4})-(\\d{2})-(\\d{2})$")
	private LocalDate dob;
	@Transient
	private boolean accountStatus;
//	@ManyToOne( fetch = FetchType.LAZY)
//	@OnDelete(action =OnDeleteAction.SET_NULL)
//	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
//	 @JsonIgnoreProperties("accountList")
//	//@JsonIgnore
	private int customerId;
	
}
