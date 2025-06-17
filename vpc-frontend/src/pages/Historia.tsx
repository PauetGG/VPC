import { useEffect, useState } from 'react';
import type ClubInfo from '../interfaces/ClubInfoInterface';

export default function Historia() {
  const [info, setInfo] = useState<ClubInfo | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/api/club-info/3')
      .then(res => res.json())
      .then(data => {
        setInfo(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Error al carregar la història:", err);
        setLoading(false);
      });
  }, []);

  const galeriaFotos: { src: string }[] = [
    { src: "/historia/1963.png" },
    { src: "/historia/foto2.png"},
    { src: "/historia/foto3.png"},
    { src: "/historia/foto4.png"},
    { src: "/historia/foto5.png"}
  ];

  if (loading) {
    return <p className="text-center p-10 text-lg text-gray-500">Carregant història...</p>;
  }

  if (!info) {
    return <p className="text-center p-10 text-red-500">No s’ha trobat informació de la història.</p>;
  }

  return (
    <div className="p-8">
      {/* Títol decorat */}
      <div className="w-full flex justify-center mb-10">
        <h1 className="text-4xl font-extrabold text-black text-center relative after:content-[''] after:absolute after:w-3/4 after:h-1 after:bg-black after:bottom-[-10px] after:left-1/2 after:transform after:-translate-x-1/2 after:rounded-full">
          {info.titulo}
        </h1>
      </div>

      <div className="max-w-3xl mx-auto text-center">
        {/* Imatge principal */}
        <img
          src={info.imagenPrincipal}
          alt={info.titulo}
          className="rounded-lg shadow-md w-full mb-6 object-cover max-h-[400px]"
        />

        {/* Contingut HTML des de l’API */}
        <div
          className="text-left text-gray-800 space-y-4 leading-relaxed"
          dangerouslySetInnerHTML={{ __html: info.contenido }}
        />

        {/* Galeria històrica */}
        <div className="mt-12 text-left">
        <h2 className="text-2xl font-semibold mb-4 text-black">Galeria històrica</h2>

        <div className="overflow-x-auto">
            <div className="flex gap-6 pb-4">
            {galeriaFotos.map((foto, index) => (
                <div key={index} className="flex-shrink-0 w-64">
                <img
                    src={foto.src}
                    alt={`Foto històrica ${index + 1}`}
                    className="w-full h-44 object-cover rounded-lg shadow-md hover:scale-105 transition-transform duration-300"
                />
                </div>
            ))}
            </div>
        </div>
        </div>
      </div>
    </div>
  );
}
