import { useEffect, useState } from 'react';
import type ClubInfo from '../interfaces/ClubInfoInterface';
import { juntaDirectiva } from '../interfaces/Junta';

export default function Junta() {
  const [info, setInfo] = useState<ClubInfo | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/api/club-info/1')
      .then(res => res.json())
      .then(data => {
        setInfo(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Error al carregar la informació de la junta:", err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p className="text-center p-10 text-lg text-gray-500">Carregant informació de la junta...</p>;
  }

  if (!info) {
    return <p className="text-center p-10 text-red-500">No s’ha trobat informació de la junta.</p>;
  }

  return (
    <div className="p-8">
      {/* Títol amb decoració */}
      <div className="w-full flex justify-center mb-10">
        <h1 className="text-4xl font-extrabold text-black text-center relative after:content-[''] after:absolute after:w-3/4 after:h-1 after:bg-black after:bottom-[-10px] after:left-1/2 after:transform after:-translate-x-1/2 after:rounded-full">
          {info.titulo}
        </h1>
      </div>

      {/* Contingut */}
      <div className="max-w-3xl mx-auto text-center">
        <img
          src={info.imagenPrincipal}
          alt={info.titulo}
          className="rounded-lg shadow-md w-full mb-6 object-cover max-h-[400px]"
        />

       {/* Targetes dels membres */}
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 mt-12">
        {juntaDirectiva.map((membre, index) => (
            <div
            key={index}
            className="bg-white rounded-lg shadow-md p-4 text-center hover:scale-105 transition-transform"
            >
            <img
                src={membre.imatge}
                alt={membre.nom}
                className="w-32 h-32 object-cover rounded-full mx-auto mb-4 border-2 border-gray-300"
            />
            <h3 className="text-xl font-bold text-black">{membre.nom}</h3>
            <p className="text-gray-600">{membre.carrec}</p>
            </div>
        ))}
        </div>

        {/* Espai per a més coses si vols afegir fotos o contactes */}
        {/* Per exemple: targetes amb fotos dels membres */}
      </div>
    </div>
  );
}
