import type Jugador from "./JugadorInterface";

export default interface Equip {
  id: number;
  nombre: string;
  descripcion: string;
  jugadores: Jugador[];
}