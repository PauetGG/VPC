import { useEffect, useState } from "react";

interface Producte {
  id: number;
  nombre: string;
  descripcion: string;
  imagen: string;
  precio: number;
  categoria: string;
  linkExterno: string;
  visible: boolean;
}

export default function Botiga() {
  const [productes, setProductes] = useState<Producte[]>([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/productos")
      .then((res) => res.json())
      .then((data) => {
        const visibles = data.filter((prod: Producte) => prod.visible);
        setProductes(visibles);
      })
      .catch((err) => console.error("Error carregant productes:", err));
  }, []);

  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      {/* Títol decorat */}
      <div className="w-full flex justify-center mb-10">
        <h1 className="text-4xl font-extrabold text-black text-center relative after:content-[''] after:absolute after:w-3/4 after:h-1 after:bg-black after:bottom-[-10px] after:left-1/2 after:transform after:-translate-x-1/2 after:rounded-full">
          Botiga del Club
        </h1>
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        {productes.map((prod) => (
          <div
            key={prod.id}
            className="bg-white rounded-lg shadow-md p-4 flex flex-col justify-between overflow-hidden transform transition duration-300 hover:scale-105 hover:shadow-xl"
          >
            <img
              src={prod.imagen}
              alt={prod.nombre}
              className="w-full h-48 object-contain rounded"
            />
            <div className="mt-4 flex-1">
              <h2 className="text-lg font-semibold mb-1">{prod.nombre}</h2>
              <p className="text-sm text-gray-700 mb-2">{prod.descripcion}</p>
              <p className="font-bold  mb-2">
                {prod.precio.toFixed(2)} €
              </p>
            </div>
            <a
              href={prod.linkExterno}
              target="_blank"
              rel="noopener noreferrer"
              className="mt-2 text-center bg-black text-white py-2 px-4 rounded hover:text-[oklch(0.87_0.17_100.69)] transition"
            >
              Comprar
            </a>
          </div>
        ))}
      </div>
    </div>
  );
}
