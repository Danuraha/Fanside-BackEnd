//package org.ticketreservation.moviefan.Security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.SignatureException;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//@Component
//public class JwtTokenProvider {
//
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    @Value("${jwt.tokenValidityInMilliseconds}")
//    private long tokenValidityInMilliseconds;
//
////    @Autowired
////    public JwtTokenProvider(Environment env) {
////
////        this.jwtSecret = env.getProperty("jwt.secret");
////        this.tokenValidityInMilliseconds = Long.parseLong(env.getProperty("jwt.tokenValidityInMilliseconds"));
////    }
//
//
//    public String generateToken(Authentication authentication) {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + tokenValidityInMilliseconds);
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("username", userDetails.getUsername());
//        claims.put("authorities", userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList()));
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .setClaims(claims)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    // Optional method for token validation (consider integrating with Spring Security filters)
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException ex) {
//            // Invalid JWT signature
////            logger.error("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            // Invalid JWT structure
////            logger.error("Invalid JWT structure");
//        } catch (ExpiredJwtException ex) {
//            // JWT expired
////            logger.error("JWT expired");
//        } catch (UnsupportedJwtException ex) {
//            // Unsupported JWT
////            logger.error("Unsupported JWT");
//        } catch (IllegalArgumentException ex) {
//            // JWT claims string is empty or null
////            logger.error("JWT claims string is empty or null");
//        }
//        return false;
//    }
//
//    // Optional method for extracting user details from a valid JWT token
//    public UserDetails getUserDetailsFromToken(String token) {
//        if (validateToken(token)) {
//            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//            String username = (String) claims.get("username");
//
//            // Extract authorities (might require casting or conversion)
//            List<String> rawAuthorities = (List<String>) claims.get("authorities");
//            List<SimpleGrantedAuthority> authorities = rawAuthorities.stream()
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
//
//            UserDetails userDetails = new User(username, "", authorities);
//            return userDetails;
//        }
//        return null;
//    }
//
//    // Spring Security Integration (Optional - for custom JWT filters)
//    public static boolean validateToken(HttpServletRequest request) {
//        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (token != null && token.startsWith("Bearer ")) {
//            token = token.substring(7);
//            return new JwtTokenProvider().validateToken(token); // Inject environment if needed
//        }
//        return false;
//    }
//}
