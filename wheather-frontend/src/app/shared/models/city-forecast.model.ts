export class CityForecast{
    constructor(
        public cityName: string,
        public maxTemperature: number,
        public minTemperature: number,
        public temperatureDescription: string,
        public temperatureIcon: string,
        public date : Date) { }
}