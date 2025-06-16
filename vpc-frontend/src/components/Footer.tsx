import { FaInstagram, FaFacebookF, FaYoutube, FaXTwitter } from 'react-icons/fa6';
import { Link } from 'react-router-dom';

export default function Footer() {
  return (
    <footer className="bg-black text-white text-center px-6 pt-12 pb-6">
      {/* Logo + Redes */}
      <div className="mb-6">
        <img src="/logos/vpc_logo.png" alt="Logo VPC" className="h-28 mx-auto mb-4" />
        <div className="flex justify-center space-x-4 text-xl">
          <a href="https://x.com/vpcandorra" target="_blank" rel="noopener noreferrer">
            <FaXTwitter className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
          <a href="https://www.instagram.com/vpcandorra/" target="_blank" rel="noopener noreferrer">
            <FaInstagram className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
          <a href="https://www.facebook.com/VPCANDORRA/" target="_blank" rel="noopener noreferrer">
            <FaFacebookF className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
          <a href="https://www.youtube.com/c/RugbiAndorra" target="_blank" rel="noopener noreferrer">
            <FaYoutube className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
        </div>
      </div>

      {/* Menú de navegación */}
      <nav className="flex flex-wrap justify-center space-x-4 text-sm font-semibold uppercase mb-6">
        <Link to="/" className="hover:text-[oklch(0.87_0.17_100.69)]">Inici</Link>
        <Link to="/equips" className="hover:text-[oklch(0.87_0.17_100.69)]">Equips</Link>
        <Link to="/club" className="hover:text-[oklch(0.87_0.17_100.69)]">El Club</Link>
        <Link to="/socis" className="hover:text-[oklch(0.87_0.17_100.69)]">Socis</Link>
        <Link to="/noticies" className="hover:text-[oklch(0.87_0.17_100.69)]">Notícies</Link>
        <Link to="/patrocinadors" className="hover:text-[oklch(0.87_0.17_100.69)]">Patrocinadors</Link>
        <Link to="/botiga" className="hover:text-[oklch(0.87_0.17_100.69)]">Botiga</Link>
        <Link to="/contacte" className="hover:text-[oklch(0.87_0.17_100.69)]">Contacte</Link>
      </nav>

      {/* Logos institucionals */}
      <div className="flex flex-wrap justify-center items-center gap-6 mb-6">
        <img src="/logos/far.png" alt="Federació Andorrana de Rugbi" className="h-18" />
        <img src="/logos/fcr.png" alt="Federació Catalana de Rugbi" className="h-18" />
        <img src="/logos/fer.png" alt="Federació Espanyola de Rugbi" className="h-18" />
      </div>

      {/* Legal */}
      <div className="text-xs text-gray-400 mb-2">
        © 2025 VPC Andorra Rugby Club
      </div>
      <div className="text-xs text-gray-400 space-x-2">
        <a href="#" className="hover:text-[oklch(0.87_0.17_100.69)]">Política de Privacitat</a>
        <span>|</span>
        <a href="#" className="hover:text-[oklch(0.87_0.17_100.69)]">Política de Cookies</a>
        <span>|</span>
        <a href="#" className="hover:text-[oklch(0.87_0.17_100.69)]">Termes i Condicions</a>
        <span>|</span>
        <a
          href="https://www.exemple.dev"
          className="hover:text-[oklch(0.87_0.17_100.69)]"
          target="_blank"
          rel="noopener noreferrer"
        >
          Desenvolupament web Pau Gallardo
        </a>
      </div>
    </footer>
  );
}
