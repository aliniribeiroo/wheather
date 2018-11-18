import { City } from "./city.model";

export class cityDTO implements City{
    constructor(
        public cityId: string,
        public name: string,
        public country: string) { }
}