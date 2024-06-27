{
  description = "The famous missile wars Minecraft mini game packaged for papermc with Nix.";

  inputs = {
    flake-utils.url = "github:numtide/flake-utils";
    nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
  };

  outputs =
    { nixpkgs, flake-utils, ... }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = import nixpkgs { inherit system; };
        jdk = pkgs.jdk17;
      in
      {
        packages.default = pkgs.callPackage ./package.nix { inherit jdk pkgs; };
        devShell = pkgs.mkShell {
          packages = [
            pkgs.maven
            pkgs.papermc
            jdk
          ];
        };
      }
    );

}
