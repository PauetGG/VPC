import { useEffect, useState } from 'react';
import type ClubInfo from '../interfaces/ClubInfoInterface';

export default function Estadi() {
  const [info, setInfo] = useState<ClubInfo | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/api/club-info/2')
      .then(res => res.json())
      .then(data => {
        setInfo(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Error al carregar la informació de l’estadi:", err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p className="text-center p-10 text-lg text-gray-500">Carregant informació de l’estadi...</p>;
  }

  if (!info) {
    return <p className="text-center p-10 text-red-500">No s’ha trobat informació sobre l’estadi.</p>;
  }

  return (
    <div className="p-8">
      {/* Títol */}
      <div className="w-full flex justify-center mb-10">
        <h1 className="text-4xl font-extrabold text-black text-center relative after:content-[''] after:absolute after:w-3/4 after:h-1 after:bg-black after:bottom-[-10px] after:left-1/2 after:transform after:-translate-x-1/2 after:rounded-full">
          {info.titulo}
        </h1>
      </div>

      <div className="max-w-4xl mx-auto text-center">
        {/* Imatge principal */}
        <img
          src={info.imagenPrincipal}
          alt={info.titulo}
          className="rounded-lg shadow-md w-full mb-6 object-cover max-h-[400px]"
        />

        {/* Contingut HTML des de l’API */}
        <div
          className="text-left text-gray-800 space-y-4 mb-10 leading-relaxed"
          dangerouslySetInnerHTML={{ __html: info.contenido }}
        />

        {/* Mapa */}
        <div className="mt-12">
          <h2 className="text-2xl font-semibold mb-4 text-black">Ubicació a Google Maps</h2>
          <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2892.1058368129254!2d1.5886996157331365!3d42.53429817917888!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12a4655cbfb86d7d%3A0x9e1d1f0f3be9f7d!2sPrada%20de%20Moles!5e0!3m2!1sca!2sad!4v1687000000000!5m2!1sca!2sad"
            width="100%"
            height="300"
            loading="lazy"
            allowFullScreen
            className="rounded-md shadow-md border"
          ></iframe>
        </div>

        {/* Característiques */}
        <div className="mt-12">
          <h2 className="text-2xl font-semibold mb-4 text-black">Característiques destacades</h2>
          <ul className="list-disc list-inside text-left text-gray-700 text-lg">
            <li>Capacitat per a més de 3.000 espectadors</li>
            <li>Gespa artificial d’última generació</li>
            <li>Ubicat al cor d’Encamp</li>
            <li>Instal·lacions modernes per entrenaments i competició</li>
          </ul>
        </div>
      </div>
    </div>
  );
}
