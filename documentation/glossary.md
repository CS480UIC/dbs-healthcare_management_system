## 1)Per each entity, document name, synonyms, and description in the glossary <br/><br/>

**Entity Name**: doctor

**Synonyms**: Medical practitioner, Clinician, Medic, Surgeon

**Description**: A doctor is a health professional who practices medicine, and treats patients who are ill or injured or in need of treatment. <br/><br/>

**Entity Name**: patient

**Synonyms**: Sick person, A person suffering from a disease

**Description**: A patient is any recipient of health care services that are performed by healthcare professionals. The patient who is ill or injured is treated by the doctor.<br/><br/>

**Entity Name**: medication

**Synonyms**: Antibiotic, Drug, Pill

**Description**: A medication is a drug used to diagnose, treat the patient. A medication is a drug that is given by a doctor to a patient who is ill, injured or in need of treatment.<br/><br/>

**Entity Name**: medical_history 

**Synonyms**: Medical record, Health history

**Description**: The medical history of a patient is information gained by a doctor by asking the patient a few specific questions to formulate the required diagnosis and provide the right medical care to the patient. <br/><br/>

**Entity Name**: payment

**Synonyms**: Fee, Charges

**Description**: A payment is the fee charged by the hospital from the patient for treating the patient and providing the patient with health care services. <br/><br/>

**Entity Name**: hospital

**Synonyms**: Health Center, Clinic

**Description**: A hospital is an institution, where patients get admitted to and receive the right healthcare services from the doctors. <br/><br/>

**Entity Name**: insurance

**Synonyms**: Health plan, Medicare

**Description**: Health insurance is a contract that requires an insurer to pay some or all of a patient's healthcare costs in exchange for a monthly/yearly plan chosen by the patient. <br/><br/>



## 2) Per each relationship, determine relationship maxima and minima and document it in the glossary

patient M(0) consults doctor 1(1)

doctor 1(1) worksAt  hospital M(1)

patient 1(1) contains patient_medical_history 1(1)

patient 1(1) makes payment M(1)

patient M(0) visits hospital 1(1)

patient 1(1) takes medication M(0)

doctor 1(1) recommends medication M(0)

patient 1(1) opts insurance M(0)<br/><br/>


## 3)Per each attribute, determine attribute maxima and minima and document it in the glossary 

### doctor Attributes <br/><br/>

doctor_id: 1-1(1)

first_name : M-1(1)

last_name: M-1(1)

contact_no: 1-M(1)

email: 1-M(1)

experience: 1-1(1)

department: M-M(1)

address: M-1(1)

hosipital_id: M-1(1)<br/><br/>

### patient Attributes<br/><br/>

patient_id: 1-1(1)

first_name : M-1(1)

last_name: M-1(1)

contact_no: 1-M(1)

email: 1-M(1)

gender: M-1(1)

age: M-1(1)

address: M-1(1)

user_name: 1-1(1)

password: 1-1(1)

hosipital_id: M-1(1)

doctor_id: M-1(1)<br/><br/>

### medication Attributes<br/><br/>

medication_id: M-1(1)

medicine_name: M-1(1)

price: M-1(1)

mfg_date: M-1(1)

exp_date: M-1(1)

mfg_company: M-M(1)

doctor_id: M-1(1)

patient_id: M-1(1)<br/><br/>

### patient_medical_history Attributes <br/><br/>

history_id: 1-1(1)

surgeries: 1-M(0)

medication: 1-M(0)

conditions: 1-M(1)

last_visit: 1-1(1)

patient_id: 1-1(1)<br/><br/>

### payment Attributes <br/><br/>

payment_id: 1-1(1)

first_name : M-1(1)

last_name: M-1(1)

type_of_payment : M-M(1)

treatment: M-M(1)

doc_referred: M-1(1)

date: M-1(1)

patient_id: M-1(1)<br/><br/>

### hospital Attributes<br/><br/>

hosipital_id: 1-1(1)

name : M-1(1)

contact_no: 1-M(1)

email: 1-M(1)

address: 1-1(1)

employee_count: 1-1(1)

mfg_company: M-M(1)

doctor_id: M-1(1)

patient_id: M-1(1)<br/><br/>

### insurance Attributes<br/><br/>
insurance_id: 1-1(1)

insurance_company: M-M(0)

start_date: M-1(0)

end_date: M-1(0)

insurance_plan: M-1(0)

patient_id: 1-1(1)


### Document dependent entities and dependency relationships

Dependent Entities: patient,payment, doctor, patient_medical_history, medication

Dependency relationship: 1)patient makes payment

2)patient opts insurance

3)patient contains patient_medical_history 


### Document supertypes, subtypes, and partitions

Supertype and subtype relationship
patient is a supertype of patient_medical_history entity


### Specify cascade and restrict actions for dependency relationships

patient on delete patient_medical_history cascade


### Specify cascade and restrict rules on foreign keys that implement dependency relationships

patient_id(FK) in payment table ->patient_id(PK) in patient table on delete cascade.


patient_id(FK) in Insurance table ->patient_id(PK) in patient table on delete cascade.


### Implementing attribute type:

#### 1) Doctor Entity Attributes 


doctor_id: Type: INTEGER NOT NULLDescription: Uniquely stores the doctor records in a table


first_name Type: VARCHAR(20) NOT NULL Description: First name specifies the string for the first name of the user.


last_name: Type: VARCHAR(20) NOT NULL Description: The last name specifies the string for the first name of the user.


contact_no: LONG NOT NULL Description: Stores the phone number of the doctor


email: Type: VARCHAR(20) NOT NULL Description: email specifies the string for the email of the user.


experience: Type: INTEGER NOT NULL Description: Stores the experience of the doctor


department: Type: VARCHAR(20) NOT NULL Description: Stores the department of the doctor belonging to.


address: Type: VARCHAR(20) NOT NULL Description: specifies the address for the doctor 


hosipital_id: Type: INTEGER NOT NULL Description: Foreign key which connects to the hospital entity.


#### medication Attribute


medication_id: Type: INTEGER NOT NULL Description: medicine_id specifies the the particular id for that medicine


medicine_name: Type: VARCHAR(100) NOT NULL Description: Specifies the name of the medicine


price: Type: INTEGER Description:Specifies the price of the medicine


mfg_date: Type: DATE NOT NULL Description: Stores the manufacturing date of the medicine.


exp_date: Type: DATE NOT NULL Description: Stores the expiring date of the medicine.


mfg_company: Type: VARCHAR(100) NOT NULL Description: Stores the company name of the medicine.


doctor_id: Type: INTEGER NOT NULL Description: Foreign key which connects to the doctor entity.


patient_id: Type: INTEGER NOT NULL Description: Foreign key which connects to the patient entity.


#### payment Attributes 


payment_id: Type: INTEGER NOT NULL Description: payment_id specifies the the particular id for that transaction


first_name : VARCHAR(20) NOT NULL Description: First name specifies the string for the first name of the patient.


last_name: VARCHAR(20) NOT NULL Description: Last name specifies the string for the last name of the patient.


type_of_payment : VARCHAR(20) NOT NULL Description: Type of payment specifies the string for the payment type the patient opted for.


treatment: VARCHAR(20) NOT NULL Description: Treatment specifies the string for the treatment the patient undertook.


doc_referred: VARCHAR(20) NOT NULL Description: Doc_referred specifies the string for the doctor which the patient consulted.


date: DATE NOT NULL Description: Date specifies the date when the patient consulted the doctor.


patient_id: INTEGER NOT NULL Description: Foreign key which connects to the patient entity.






