import {stringify} from 'querystring';

export class CleanData {
  filename: string;
  errorMessage?: string;
  personRecords?: PersonRecord[];
  nonDuplicates?: PersonRecord[];
  duplicateGroups?: DuplicateGroup[];
}

export class PersonRecord {
  recordNumber: number;
  id: string;
  firstName: string;
  lastName: string;
  companyName: string;
  email: string;
  address1: string;
  address2: string;
  zip: string;
  city: string;
  stateLong: string;
  state: string;
  phone: string;
  duplicates: number[];
}

export class DuplicateGroup {
  duplicates: PersonRecord[];
}

