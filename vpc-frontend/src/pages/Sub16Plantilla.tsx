import { useEffect, useState } from "react";
import type Equip from "../interfaces/EquipInterface";
import type Jugador from "../interfaces/JugadorInterface";

export default function Sub16Plantilla() {
  const [equip, setEquip] = useState<Equip | null>(null);
  const [loading, setLoading] = useState(true);
  const [selectedJugador, setSelectedJugador] = useState<Jugador | null>(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/equipos/5")
      .then((res) => res.json())
      .then((data) => {
        setEquip(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Error carregant equip Sub16:", err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p className="text-center p-10 text-lg text-gray-500">Carregant plantilla...</p>;
  }

  if (!equip) {
    return <p className="text-center p-10 text-red-500">No s’ha trobat informació de l’equip.</p>;
  }

  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      {/* Títol decorat */}
      <div className="w-full flex justify-center mb-10">
        <h1 className="text-4xl font-extrabold text-black text-center relative after:content-[''] after:absolute after:w-3/4 after:h-1 after:bg-black after:bottom-[-10px] after:left-1/2 after:transform after:-translate-x-1/2 after:rounded-full">
          {equip.nombre}
        </h1>
      </div>

      {/* Jugadors */}
      <div className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 gap-6">
        {equip.jugadores.map((jugador) => (
          <div
            key={jugador.id}
            className="bg-white rounded-lg shadow-md p-4 flex flex-col items-center text-center transition transform hover:scale-105 hover:shadow-xl cursor-pointer"
            onClick={() => setSelectedJugador(jugador)}
          >
            <img
              src={jugador.foto}
              alt={jugador.nombre}
              className="w-32 h-32 object-cover rounded-full mb-4 border-2 border-black"
            />
            <h2 className="text-lg font-bold">{jugador.nombre}</h2>
          </div>
        ))}
      </div>

      {/* Modal */}
      {selectedJugador && (
        <div className="fixed inset-0  bg-opacity-40 backdrop-blur-sm flex items-center justify-center z-50">
          <div className="bg-white rounded-lg p-6 w-full max-w-md relative shadow-xl">
            <button
              className="absolute top-2 right-4 text-gray-600 text-xl hover:text-red-500 cursor-pointer"
              onClick={() => setSelectedJugador(null)}
            >
              &times;
            </button>
            <img
              src={selectedJugador.foto}
              alt={selectedJugador.nombre}
              className="w-32 h-32 object-cover rounded-full mx-auto border-2 border-black mb-4"
            />
            <h2 className="text-2xl font-bold text-center mb-2">{selectedJugador.nombre}</h2>
            <p className="text-center text-gray-700 mb-1"><strong>Posició:</strong> {selectedJugador.posicion}</p>
            <p className="text-center text-gray-700 mb-1"><strong>Nacionalitat:</strong> {selectedJugador.nacionalidad || '—'}</p>
            <p className="text-center text-gray-700"><strong>Data naixement:</strong> {selectedJugador.fechaNacimiento ? new Date(selectedJugador.fechaNacimiento).toLocaleDateString() : '—'}</p>
          </div>
        </div>
      )}
    </div>
  );
}
