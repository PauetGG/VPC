import { Link } from 'react-router-dom';
import { FaInstagram, FaFacebookF, FaYoutube, FaXTwitter } from 'react-icons/fa6';

export default function Header() {
  return (
    <header className="bg-black text-white w-full">
      {/* Primera línea: Logo + Redes */}
      <div className="relative flex items-center justify-center px-6 py-6 min-h-[100px] border-b border-white/10">
        {/* Logo centrado absoluto */}
        <div className="absolute left-1/2 -translate-x-1/2">
          <img src="/logos/vpc_logo.png" alt="Logo VPC" className="h-24" />
        </div>

        {/* Redes sociales a la derecha */}
        <div className="ml-auto flex space-x-4 text-xl">
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

      {/* Segunda línea: Menú */}
      <div className="flex justify-center items-center space-x-8 px-6 py-4 min-h-[60px] border-t border-white/10 text-sm font-bold uppercase tracking-wide">
        <Link to="/equips" className="hover:text-[oklch(0.87_0.17_100.69)]">Equips</Link>
        <Link to="/club" className="hover:text-[oklch(0.87_0.17_100.69)]">El Club</Link>
        <Link to="/socis" className="hover:text-[oklch(0.87_0.17_100.69)]">Socis</Link>
        <Link to="/noticies" className="hover:text-[oklch(0.87_0.17_100.69)]">Notícies</Link>
        <Link to="/patrocinadors" className="hover:text-[oklch(0.87_0.17_100.69)]">Patrocinadors</Link>
        <Link to="/botiga" className="hover:text-[oklch(0.87_0.17_100.69)]">Botiga del Club</Link>
      </div>
    </header>
  );
}

