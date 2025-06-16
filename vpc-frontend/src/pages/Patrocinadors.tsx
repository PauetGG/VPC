import { useEffect, useState } from 'react';

interface Patrocinador {
  id: number;
  nombre: string;
  logo: string;
  urlWeb: string;
  descripcion: string;
}

export default function Patrocinadors() {
  const [patrocinadors, setPatrocinadors] = useState<Patrocinador[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/api/patrocinadores')
      .then(res => res.json())
      .then(data => {
        setPatrocinadors(data);
        setLoading(false);
      })
      .catch(err => {
        console.error('Error al cargar patrocinadores:', err);
        setLoading(false);
      });
  }, []);

  return (
    <div className="p-8">
      <h1 className="text-3xl font-bold mb-6">Patrocinadors</h1>
      {loading ? (
        <p>Carregant patrocinadors...</p>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {patrocinadors.map(p => (
            <a
              key={p.id}
              href={p.urlWeb}
              target="_blank"
              rel="noopener noreferrer"
              className="bg-white rounded-lg shadow-md p-4 hover:scale-105 transition-transform"
            >
              <img src={p.logo} alt={p.nombre} className="h-20 mx-auto mb-4 object-contain" />
              <h2 className="text-xl font-semibold text-center">{p.nombre}</h2>
              <p className="text-sm text-gray-600 mt-2 text-center">{p.descripcion}</p>
            </a>
          ))}
        </div>
      )}
    </div>
  );
}
