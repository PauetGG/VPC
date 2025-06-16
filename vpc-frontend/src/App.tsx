import { Routes, Route, Outlet } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import Patrocinadors from './pages/Patrocinadors';
import './App.css';
// importa otras páginas aquí si las tienes

export default function App() {
  return (
    <div className="min-h-screen flex flex-col">
      <Header />
      <main className="flex-grow">
        <Routes>
          <Route path="/" element={<Outlet />}>
            <Route index element={<Home />} />
            <Route path="patrocinadors" element={<Patrocinadors />} />
            {/* más rutas aquí */}
            {/* <Route path="noticies" element={<Noticies />} /> */}
          </Route>
        </Routes>
      </main>
      <Footer />
    </div>
  );
}
