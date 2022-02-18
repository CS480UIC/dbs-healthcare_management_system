## 1)Per each entity, document name, synonyms, and description in the glossary 

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


## 2) Per each relationship, determine relationship maxima and minima and document it in the glossary

patient M(0) consults doctor 1(1)

doctor 1(1) worksAt  hospital M(1)

patient 1(1) contains patient_medical_history 1(1)

patient 1(1) makes payment M(1)

patient M(0) visits hospital 1(1)<br/><br/>


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
