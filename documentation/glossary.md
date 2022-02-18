## 1)Per each entity, document name, synonyms, and description in the glossary 

Entity Name: doctor

Synonyms: Medical practitioner, Clinician, Medic, Surgeon

Description: A doctor is a health professional who practices medicine, and treats patients who are ill or injured or in need of treatment. 


Entity Name: medical_history 

Synonyms: Medical record, Health history

Description: The medical history of a patient is information gained by a doctor by asking the patient a few specific questions to formulate the required diagnosis and provide the right medical care to the patient. 

Entity Name: payment

Synonyms: Fee, Charges

Description: A payment is the fee charged by the hospital from the patient for treating the patient and providing the patient with health care services. 


## 2) Per each relationship, determine relationship maxima and minima and document it in the glossary

patient 1(1) contains patient_medical_history 1(1)

patient 1(1) makes payment M(1)

patient 1(1) makes payment M(1)


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

hosipital_id: M-1(1)

### patient_medical_history Attributes <br/><br/>

history_id: 1-1(1)

surgeries: 1-M(0)

medication: 1-M(0)

conditions: 1-M(1)

last_visit: 1-1(1)

patient_id: 1-1(1)

### payment Attributes <br/><br/>

payment_id: 1-1(1)

first_name : M-1(1)

last_name: M-1(1)

type_of_payment : M-M(1)

treatment: M-M(1)

doc_referred: M-1(1)

date: M-1(1)

patient_id: M-1(1)
